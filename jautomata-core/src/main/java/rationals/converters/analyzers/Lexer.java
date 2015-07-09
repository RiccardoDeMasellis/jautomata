/*
 * (C) Copyright 2005 Arnaud Bailly (arnaud.oqube@gmail.com),
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
package rationals.converters.analyzers;

import rationals.converters.ConverterException;

/**
 * Interface lifting lexical analysis.
 * This interface allows customization of parsing of RE, in particular to
 * override the definition of what is a labeL. 
 * Instances of Lexer are used by instances of Parser to retrieve tokens.
 * @author nono
 * @version $Id: Lexer.java 2 2006-08-24 14:41:48Z oqube $
 * @see DefaultLexer
 * @see Parser
 */
public interface Lexer<L> {
    int LABEL = 0;

    int INT = 1;

    int EPSILON = 2;

    int EMPTY = 3;

    int ITERATION = 4;

    int UNION = 5;

    int STAR = 6;

    int OPEN = 7;

    int CLOSE = 8;

    int END = 9;

    int UNKNOWN = 10;

    // AB
    int SHUFFLE = 11;

    int MIX = 12;

    int OBRACE = 13;

    int CBRACE = 14;

    /**
     * Read more data from the underying input.
     * 
     * @throws ConverterException if some characters cannot be converted
     */
    void read() throws ConverterException;

    /**
     * Return the current line number in the underlying character
     * stream.
     * Line separation is platform dependent.
     * 
     * @return number of current line, starting from 1
     */
    int lineNumber();

    /**
     * Return the image of current token.
     * This method is used by Parser to create atomic Automaton objects
     * so any Object can be used.
     * 
     * @return an Object which is a label for a transition.
     */
    L label();

    /**
     * Return the value of a number.
     * 
     * @return value of a number.
     */
    int value();

    /**
     * Returns the current token value.
     * This value must be one of the constants defined in interface Lexer.
     * 
     * @return a constant denoting the kind of token.
     */
    int current();
}