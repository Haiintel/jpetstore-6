import org.mybatis.jpetstore.service.CatalogService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/catalog/products")
public class CatalogSearchController {

  private final CatalogService catalogService;

  public CatalogSearchController(CatalogService catalogService) {
    this.catalogService = catalogService;
  }

  @GetMapping("/search")
  public SearchResponse search(@RequestParam String keyword) {
    String normalizedKeyword = CatalogSearchValidation.normalizeKeyword(keyword);
    try {
      return new SearchResponse(
          catalogService.searchProductList(normalizedKeyword).stream().map(ProductDto::from).toList());
    } catch (RuntimeException ex) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Catalog search failed", ex);
    }
  }
}