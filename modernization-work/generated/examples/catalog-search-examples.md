## Request

`GET /api/catalog/products/search?keyword=fish`

## Success response

```json
{
  "items": [
    {
      "productId": "FI-SW-01",
      "name": "Angelfish",
      "description": "Salt Water fish from Australia",
      "categoryId": "FISH"
    }
  ]
}
```

## Validation error

`GET /api/catalog/products/search?keyword=`

```json
{
  "error": "keyword is required"
}
```

## Legacy behavior preserved

- Read-only product lookup only
- Empty keyword rejected
- Case-insensitive product-name search delegated to existing `CatalogService`
- Multi-word search behavior remains with the legacy service implementation