import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

final class CatalogSearchValidation {

  private CatalogSearchValidation() {
  }

  static String normalizeKeyword(String keyword) {
    String value = keyword == null ? "" : keyword.trim();
    if (value.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "keyword is required");
    }
    return value;
  }
}