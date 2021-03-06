/*
 * (C) Copyright 2013 Arnaud Bailly (arnaud.oqube@gmail.com),
 *     Yves Roos (yroos@lifl.fr) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the License);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an AS IS BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rationals.transformations;

import rationals.Automaton;

import java.util.Set;

public class PartialCommutation implements UnaryTransformation{
    private final Set commutingLetters;

    public PartialCommutation(Set commutingLetters) {
        this.commutingLetters = commutingLetters;
    }

    public Automaton transform(Automaton a) {
        Automaton b = new Automaton();
        return a;
    }
}
