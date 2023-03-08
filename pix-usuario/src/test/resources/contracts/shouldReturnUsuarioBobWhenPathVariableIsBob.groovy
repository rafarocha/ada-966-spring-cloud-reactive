package contracts

import org.springframework.cloud.contract.spec.Contract

/* groovylint-disable-next-line CompileStatic */
Contract.make {
    description 'obter o usuario bob'
    request {
        method GET()
        url('/usuarios/bob')
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body([
            nome: "Bob",
            username: "bob"
        ])
        headers {
            contentType(applicationJson())
        }
    }
}