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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 * or see http://www.gnu.org/licenses/gpl.html
 *
 * In addition, as a special exception, the JavaPLT group at Rice University
 * (javaplt@rice.edu) gives permission to link the code of DrJava with
 * any Java compiler, even if it is provided in binary-only form, and distribute
 * linked combinations including the two.  You must obey the GNU General Public
 * License in all respects for all of the code used other than Java compilers.
 * If you modify this file, you may extend this exception to your version of the
 * file, but you are not obligated to do so.  If you do not wish to
 * do so, delete this exception statement from your version.
 *
END_COPYRIGHT_BLOCK*/

package edu.rice.cs.drjava.model.repl;

/**
 * Interface for repl interpreters.
 * @version $Id$
 */
public interface JavaInterpreter {
  /** Value returned to indicate no result. */
  public static final Object NO_RESULT = new Object();

  /**
   * Interprets the given string.
   * @param s Java source to interpret
   * @return The result of the interpretation, or {@link #NO_RESULT} if
   *         the interpretation had no return value.
   */
  public Object interpret(String s) throws ExceptionReturnedException;

  /**
   * Adds the given path to the interpreter's classpath.
   * @param path Path to add
   */
  public void addClassPath(String path);

  /**
   * Set the scope for unqualified names to the given package.
   * @param packageName Package to assume scope of.
   */
  public void setPackageScope(String packageName);
}
