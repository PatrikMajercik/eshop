# eshop

Simple rest apllication as a task for Cleevio company.


For starting application use this command in projects root dictionary.

```
./mvnw spring-boot:run
```

### Create request example
Use this command in terminal

```
curl -X POST -H "Content-type: application/json" -d "{\"title\": \"Prim\",\"price\": \"250000\",\"description\": \"A watch with a water fountain picture\",\"imageBase64\": \"ZHNhZHNhZHNhZHNhZHNhZHNhZGFzZGFkcw==\"}" "http://localhost:8080/api/watch/create"
```

Formatted JSON
``` JSON
{
    "title": "Prim",
    "price": "250000",
    "description": "A watch with a water fountain picture",
    "imageBase64": "ZHNhZHNhZHNhZHNhZHNhZHNhZGFzZGFkcw=="
}
```


## Possible improvements
- Add more unit tests
- Add integration test for each layer
- Use static code analysis in CI
- Decompose application into separate maven project to have each layer standalone.
