package efub.ebs.ebs01.dao;

import efub.ebs.ebs01.dto.ContentsDTO;

import java.util.List;

public interface ContentsDAO {
    List<ContentsDTO> selectContents(ContentsDTO param) throws Exception;
    ContentsDTO selectContentsById(int contentsId) throws Exception;
}
