/*
 * (C) Copyright 2002 Arnaud Bailly (arnaud.oqube@gmail.com),
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
package rationals.converters.algorithms;

import java.util.Map;

/**
 * The base interface for all DisplayAlgorithms. A LayoutAlgorithm is
 * used to compute layout for an Automaton object. The normal way to use it
 * is : 
 * <ul>
 * <li>define the automaton to layout with layout(Automaton a) ;</li>
 * <li>repeatedly call work() while done() is false ;</li>
 * <li>retrieve computed coordinates for states with state().</li>
 * </ul>
 * <p>
 * Methods work() and done() can be used to compute layout incrementally for
 * algorithm which supports this concept.
 * <p>
 * Methods tweak(...) are used to handle customization of algortithms parameters
 * generically with tools or command line parameters.
 * 
 * @author Arnaud Bailly 
 * @version 22032002
 */
public interface LayoutAlgorithm {

	/**
	 * starts display of automaton
	 *
	 * @param aut rationals.Automaton to display
	 * @return a Map of states to coords 
	 */
	void layout(rationals.Automaton aut)
		throws rationals.converters.ConverterException;

	/**
	 * Method called by clients to ask the algorithm to perform
	 * an incremental work. The definition of an increment of work
	 * is algorithm dependent
	 */
	void work();

	/**
	 * This methods should be used by clients of algorithms to check
	 * termination of algorithm
	 * 
	 * @return true if algorithm has terminated, false otherwise
	 * */
	boolean done();

	/**
	 * Retrieve the current state of the display 
	 * 
	 * @return a map from State objects to Coord objects
	 */
	java.util.Map getState();

	/**
	 * Sets the current state of the layout
	 * 
	 * @param a Map from Coord objects to State
	 */
	void setState(Map m);
	
	/**
	 * Sets implementation defined parameters for algorithm
	 *
	 * @param prop property name to set
	 * @param val an Object used to define property
	 */
	void tweak(String prop, Object val);

	/**
	 * Sets implementation defined parameters for algorithm
	 *
	 * @param prop property name to set
	 * @param val float value 
	 */
	void tweak(String prop, double val);

	/**
	 * Sets implementation defined parameters for algorithm
	 *
	 * @param prop property name to set
	 * @param val int value 
	 */
	void tweak(String prop, int val);

	/**
	 * list tweakable properties 
	 *
	 * @return a map of String/class usable properties
	 */
	java.util.Map allParameters();

}
