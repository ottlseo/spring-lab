package efub.ebs.ebs01.controller;

import efub.ebs.ebs01.dao.CategoryDAO;
import efub.ebs.ebs01.dto.CategoryDTO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@MapperScan(basePackages="efub.ebs.ebs01.dao") //탐색할 패키지 설정
public class CategoryController {

    @Autowired
    private CategoryDAO categoryDAO; //dao bean 자동으로 주입

    @GetMapping("/category") // 카테고리 리스트 (DTO 리스트) 불러오기
    public List<CategoryDTO> getCategoryList() throws Exception{

        // 1. param 작성
        final CategoryDTO param = new CategoryDTO(0, null, null);

        // 2. param 전달하여 List 불러오기
        final List<CategoryDTO> categoryList = categoryDAO.selectCategory(param);
        return categoryList;
    }

    @GetMapping("/category/{categoryId}") // id에 따라 DTO 객체 하나 불러오기 (카테고리 1개 정보)
    public CategoryDTO getCategoryById(@PathVariable("categoryId") int categoryId) throws Exception{
        return categoryDAO.selectCategoryById(categoryId);
    }
}
