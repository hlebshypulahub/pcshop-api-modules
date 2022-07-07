package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return part by id"
    request {
        method GET()
        url("/api/v1/parts") {
            queryParameters {
                parameter("id", "1")
            }
        }
    }
    response {
        body([
                "id"          : 1,
                "name"        : "Laptop",
                "producerCode": "48239523"
        ])
        headers {
            contentType applicationJson()
        }
        status 200
    }
}
