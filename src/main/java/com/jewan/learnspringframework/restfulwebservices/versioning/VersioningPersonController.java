package com.jewan.learnspringframework.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    // Rest API 버전관리

    // 1. URL
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("백 제완");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("백", "제완"));
    }

    // 2. Request Parameter
    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter() {
        return new PersonV1("백 제완");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter() {
        return new PersonV2(new Name("백", "제완"));
    }

    // 3. Request Header
    @GetMapping(path = "/person/header", headers = "X-API-VERSIONS=1")
    public PersonV1 getFirstVersionOfPersonRequestHeader() {
        return new PersonV1("백 제완");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSIONS=2")
    public PersonV2 getSecondVersionOfPersonRequestHeader() {
        return new PersonV2(new Name("백", "제완"));
    }

    // 4. AcceptHeader
    // +json 명시해줘야함 
    @GetMapping(path = "/person/accept", produces = "application/dev.jewan-v1+json")
    public PersonV1 getFirstVersionOfPersonAcceptHeader() {
        return new PersonV1("백 제완");
    }

    @GetMapping(path = "/person/accept", produces = "application/dev.jewan-v2+json")
    public PersonV2 getSecondVersionOfPersonAcceptHeader() {
        return new PersonV2(new Name("백", "제완"));
    }

}
