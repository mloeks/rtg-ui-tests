package de.rtg.test.ui.utils

class RandomHelper {

    /**
     * Source: https://stackoverflow.com/a/47803683
     */
    static someString(int length = 8) {
        new Random().with {(1..length).collect {(('a'..'z')).join()[ nextInt((('a'..'z')).join().length())]}.join()}
    }
}
