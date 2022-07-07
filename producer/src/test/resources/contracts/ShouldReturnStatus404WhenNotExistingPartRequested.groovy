package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return status 404 when get part by id and part not exists"
    request {
        method GET()
        url("api/v1/parts") {
            queryParameters {
                parameter("id", "9999")
            }
        }
    }
    response {
        headers {
            contentType applicationJson()
        }
        status 404
    }
}
