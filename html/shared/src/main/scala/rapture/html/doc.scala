/******************************************************************************************************************\
* Rapture HTML, version 2.0.0. Copyright 2010-2015 Jon Pretty, Propensive Ltd.                                     *
*                                                                                                                  *
* The primary distribution site is http://rapture.io/                                                              *
*                                                                                                                  *
* Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in complance    *
* with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.            *
*                                                                                                                  *
* Unless required by applicable law or agreed to in writing, software distributed under the License is distributed *
* on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License    *
* for the specific language governing permissions and limitations under the License.                               *
\******************************************************************************************************************/
package rapture.html

import rapture.dom._

package doctypes {
  object html5 {
    implicit val implicitDoctype: Doctype = Doctype("html")
  }
}

object Doctype {
  implicit val defaultDoctype: Doctype = doctypes.html5.implicitDoctype
}

case class Doctype(parts: String*) {
  override def toString = s"<!DOCTYPE ${parts mkString " "}>"
}

case class HtmlDoc(html: htmlSyntax.HtmlRoot)(implicit val doctype: Doctype) {
  def format = s"$doctype\n${html.format}"
}
