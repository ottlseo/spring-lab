package efub.ebs.ebs01.dao;

import efub.ebs.ebs01.dto.CategoryDTO;

import java.util.List;

public interface CategoryDAO {
    List<CategoryDTO> selectCategory(CategoryDTO param) throws Exception;
    CategoryDTO selectCategoryById(int categoryId) throws Exception;
}
