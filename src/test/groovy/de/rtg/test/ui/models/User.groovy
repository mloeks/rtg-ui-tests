package de.rtg.test.ui.models

class User {

    String username
    String email
    String password
    String firstName
    String lastName

    static createRandom() {
        return new User(username: 'test1234', firstName: 'Testy', lastName: 'McTestface',
                email: 'testy@mctestface.com', password: 'test1234')
    }

}
