/*BEGIN_COPYRIGHT_BLOCK
 *
 * This file is a part of DrJava. Current versions of this project are available
 * at http://sourceforge.net/projects/drjava
 *
 * Copyright (C) 2001-2002 JavaPLT group at Rice University (javaplt@rice.edu)
 *
 * DrJava is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * DrJava is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 * or see http://www.gnu.org/licenses/gpl.html
 *
 * In addition, as a special exception, the JavaPLT group at Rice University
 * (javaplt@rice.edu) gives permission to link the code of DrJava with
 * the classes in the gj.util package, even if they are provided in binary-only
 * form, and distribute linked combinations including the DrJava and the
 * gj.util package. You must obey the GNU General Public License in all
 * respects for all of the code used other than these classes in the gj.util
 * package: Dictionary, HashtableEntry, ValueEnumerator, Enumeration,
 * KeyEnumerator, Vector, Hashtable, Stack, VectorEnumerator.
 *
 * If you modify this file, you may extend this exception to your version of the
 * file, but you are not obligated to do so. If you do not wish to
 * do so, delete this exception statement from your version. (However, the
 * present version of DrJava depends on these classes, so you'd want to
 * remove the dependency first!)
 *
 END_COPYRIGHT_BLOCK*/

package edu.rice.cs.drjava.model.junit;

import edu.rice.cs.drjava.model.repl.newjvm.InterpreterJVM;
import edu.rice.cs.util.UnexpectedException;

import java.io.PrintStream;
import javax.swing.*;
import javax.swing.text.StyledDocument;
import javax.swing.text.BadLocationException;

import junit.runner.*;
import junit.framework.*;
import junit.textui.TestRunner;

/**
 * DrJava's own testrunner. It updates the document in the
 * JUnit pane as error and failure events are fired.
 *
 * @version $Id$
 */
public class JUnitTestRunner extends junit.textui.TestRunner {

  /**
   * Used to tie the output of the ui textrunner 
   * to nothing.
   */
  private PrintStream _writer;
  
  /**
   * Class loader that uses DrJava's classpath. Overrides the super class' loader.
   */
  private TestSuiteLoader _classLoader;
  
  
  /**
   * Constructor
   */
  public JUnitTestRunner(InterpreterJVM jvm) {
    super();
    _classLoader = new DrJavaTestClassLoader(jvm);
    _writer = new PrintStream(System.out) {
      public void print(String s) {
      }
      public void println(String s) {
      }
      public void println() {
      }
    };
  }

  /**
   * Overrides method in super class to always return a 
   * reloading test suite loader.
   */
  public TestSuiteLoader getLoader() {
    return _classLoader;
  }
  
  /**
   * Provides our own PrintStream which outputs
   * to the appropriate document.
   */
  protected PrintStream getWriter() {
    return _writer;
  }
  
  protected PrintStream writer() {
    return getWriter();
  }

}


