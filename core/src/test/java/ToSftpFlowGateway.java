import java.util.List;

public interface ToSftpFlowGateway {

	public List<Boolean> lsGetAndRmFiles(String dir);
}