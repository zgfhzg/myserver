package com.project.myserver.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/test"])
class TestController {
    @GetMapping
    fun test() = "Hello World"
}