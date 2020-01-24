package com.poorna.recyclerviewwithswiperefresher.entity

class BusinessMan {

    var firstName: String
    var lastName: String
    var age: Int
    var imageUrl: String

    constructor(firstName: String, lastName: String, age: Int, imageUrl: String) {
        this.firstName = firstName
        this.lastName = lastName
        this.age = age
        this.imageUrl = imageUrl
    }
}