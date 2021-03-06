/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Dr. Gernot Starke
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.cirqlizr
// see end-of-file for license information


class AssertHelper {

    /**
     * helper method to assert-with-epsilon
     */
    public static boolean assertCloseTo(expected, actual, float epsilon) {
        assert epsilon>0 : "epsilon must be > 0, was $epsilon"

        return Math.abs(Math.abs(expected) - Math.abs(actual)) <= epsilon
    }


    /**
     * helper method to assertEquals with epsilon to every element of two lists
     */
    public static boolean assertCloseTo(List<Number> actual, List<Number> expected, float epsilon) {
        if (actual == [] && expected == []) return true

        if (actual.size() == expected.size()) {
            return assertCloseTo(actual?.first(), expected?.first(), epsilon) &&
                    assertCloseTo(actual?.tail(), expected?.tail(), epsilon)
        }
        // size does not match -> error
        else return false
    }
}
