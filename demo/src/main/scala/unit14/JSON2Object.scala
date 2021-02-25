package unit14

import net.liftweb.json._
import net.liftweb.json.DefaultFormats


case class MailServer(url: String, username: String, password: String)

case class EmailAccount(
                         accountName: String,
                         url: String,
                         username: String,
                         password: String,
                         mChecks: Int,
                         usersOfInterest: List[String]
                       )

object JSON2Object extends App {


  implicit val formats = DefaultFormats

  val json1String =
    """{
      |"url":"imap.yahoo.com",
      |"username":"wuhu",
      |"password":"ps"
      |}""".stripMargin

  //  println(jsonString)
  val JValue = parse(json1String)

  val mailServer = JValue.extract[MailServer]

  println(mailServer.url, mailServer.username, mailServer.password)


  val jsonString =
    """
      |{
      |"accounts":[
      | {
      |   "emailAccount":{
      |   "accountName":"Ymail",
      |   "username":"UserName",
      |   "password":"password",
      |   "url":"www.baidu.com",
      |   "mChecks":1,
      |   "usersOfInterest":["betty","sss","aaa"]
      |   }
      | },
      |  {
      |   "emailAccount":{
      |   "accountName":"22323",
      |   "username":"UserName4444",
      |   "password":"password3333",
      |   "url":"www.baidu.com",
      |   "mChecks":1,
      |   "usersOfInterest":["betty","sss","aaa"]
      |   }
      | }
      |]
      |}
      |""".stripMargin

  val json = parse(jsonString)
  //用\\方法搜索名为emailAccount的元素
  val element = (json \\ "emailAccount").children

  for (acct <- element) {
    val m = acct.extract[EmailAccount]
    println(s"${m.url}--${m.username}--${m.password}")
  }



}
