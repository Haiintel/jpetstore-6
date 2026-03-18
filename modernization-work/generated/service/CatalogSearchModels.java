import java.util.List;

import org.mybatis.jpetstore.domain.Product;

record SearchResponse(List<ProductDto> items) {
}

record ProductDto(String productId, String name, String description, String categoryId) {
  static ProductDto from(Product product) {
    return new ProductDto(product.getProductId(), product.getName(), product.getDescription(), product.getCategoryId());
  }
}

record ErrorResponse(String error) {
}