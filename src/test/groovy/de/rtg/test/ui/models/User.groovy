package de.rtg.test.ui.models


import static de.rtg.test.ui.utils.RandomHelper.someString

class User {

    String username
    String email
    String password
    String firstName
    String lastName

    static createRandom() {
        String randomUsername = someString()
        return new User(username: randomUsername, firstName: 'Testy', lastName: 'McTestface',
                email: "${randomUsername}@rtgtest.com", password: 'test1234')
    }

}
