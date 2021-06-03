package efub.ebs.ebs01.controller;

import efub.ebs.ebs01.dao.ContentsDAO;
import efub.ebs.ebs01.dto.ContentsDTO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@MapperScan(basePackages="efub.ebs.ebs01.dao")//탐색할 패키시 설정
public class ContentsController {
    @Autowired
    private ContentsDAO contentsDAO;//contentsDAO bean을 자동으로 주입

    @GetMapping("/contents")
    public List<ContentsDTO> getContentsList() throws Exception {
        final ContentsDTO param = new ContentsDTO(0, null, null);
        final List<ContentsDTO> contentsList = contentsDAO.selectContents(param);// 윗줄에서 생성한 객체를 파라미터로 전달하여 DB로부터 사용자 목록을 불러온다.
        return contentsList;
    }
    @GetMapping("/contents/{contentsId}")
    public ContentsDTO getContentsById(@PathVariable("contentsId") int contentsId) throws Exception{
        return contentsDAO.selectContentsById(contentsId);
    }

}