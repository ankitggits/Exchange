import com.jcraft.jsch.ChannelSftp.LsEntry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.endpoint.SourcePollingChannelAdapter;
import org.springframework.integration.file.remote.RemoteFileTemplate;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ExchangeApplicationTests {
	
	@Test
	public void runDemo(){
		ConfigurableApplicationContext context =
				new ClassPathXmlApplicationContext("/SftpInboundReceiveSample-context.xml", this.getClass());
		RemoteFileTemplate<LsEntry> template = null;
		String file1 = "z.txt";
		String file2 = "y.txt";
		//String file3 = "x.bar";
		new File("local-dir", file1).delete();
		new File("local-dir", file2).delete();
		try {
			PollableChannel localFileChannel = context.getBean("receiveChannel", PollableChannel.class);
			@SuppressWarnings("unchecked")
			SessionFactory<LsEntry> sessionFactory = context.getBean(CachingSessionFactory.class);
			template = new RemoteFileTemplate<LsEntry>(sessionFactory);
			SftpTestUtils.createTestFiles(template, file1, file2);

			SourcePollingChannelAdapter adapter = context.getBean(SourcePollingChannelAdapter.class);
			adapter.start();

			Message<?> received = localFileChannel.receive();
			assertNotNull("Expected file", received);
			System.out.println("Received first file message: " + received);
			received = localFileChannel.receive();
			assertNotNull("Expected file", received);
			System.out.println("Received second file message: " + received);
			adapter.stop();
			//received = localFileChannel.receive(1000);
			//assertNull("Expected null", received);
			//System.out.println("No third file was received as expected");
		}
		finally {
			SftpTestUtils.cleanUp(template, file1, file2);
			context.close();
			//assertTrue("Could note delete retrieved file", new File("local-dir", file1).delete());
			//assertTrue("Could note delete retrieved file", new File("local-dir", file2).delete());
		}
	}
	
	@Test
	public void testOutbound() throws Exception{

		final String sourceFileName = "README.md";
		final String destinationFileName = sourceFileName +"_foo";

		ConfigurableApplicationContext context =
				new ClassPathXmlApplicationContext("/SftpInboundReceiveSample-context.xml", this.getClass());
		@SuppressWarnings("unchecked")
		SessionFactory<LsEntry> sessionFactory = context.getBean(CachingSessionFactory.class);
		RemoteFileTemplate<LsEntry> template = new RemoteFileTemplate<LsEntry>(sessionFactory);
		SftpTestUtils.createTestFiles(template); // Just the directory

		try {
			final File file = new File(sourceFileName);

			Assert.isTrue(file.exists(), String.format("File '%s' does not exist.", sourceFileName));

			final Message<File> message = MessageBuilder.withPayload(file).build();
			final MessageChannel inputChannel = context.getBean("inputChannel", MessageChannel.class);

			inputChannel.send(message);
			Thread.sleep(2000);

			Assert.isTrue(SftpTestUtils.fileExists(template, destinationFileName));

			System.out.println(String.format("Successfully transferred '%s' file to a " +
					"remote location under the name '%s'", sourceFileName, destinationFileName));
		}
		finally {
			SftpTestUtils.cleanUp(template, destinationFileName);
			context.close();
		}
	}
	
	@Test
	public void testLsGetRm() throws Exception {
		ConfigurableApplicationContext context =
				new ClassPathXmlApplicationContext("/SftpInboundReceiveSample-context.xml", this.getClass());
		ToSftpFlowGateway toFtpFlow = context.getBean(ToSftpFlowGateway.class);
		RemoteFileTemplate<LsEntry> template = null;
		String file1 = "1.ftptest";
		String file2 = "2.ftptest";
		File tmpDir = new File(System.getProperty("java.io.tmpdir"));

		try {
			// remove the previous output files if necessary
			new File(tmpDir, file1).delete();
			new File(tmpDir, file2).delete();

			@SuppressWarnings("unchecked")
			SessionFactory<LsEntry> sessionFactory = context.getBean(CachingSessionFactory.class);
			template = new RemoteFileTemplate<LsEntry>(sessionFactory);
			SftpTestUtils.createTestFiles(template, file1, file2);

			// execute the flow (ls, get, rm, aggregate results)
			List<Boolean> rmResults = toFtpFlow.lsGetAndRmFiles("si.sftp.sample");


			//Check everything went as expected, and clean up
			assertEquals(2, rmResults.size());
			for (Boolean result : rmResults) {
				assertTrue(result);
			}

		}
		finally {
			SftpTestUtils.cleanUp(template, file1, file2);
			context.close();
			assertTrue("Could note delete retrieved file", new File(tmpDir, file1).delete());
			assertTrue("Could note delete retrieved file", new File(tmpDir, file2).delete());
		}
	}


}
