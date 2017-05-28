package controllers

import jsmessages.api.JsMessages
import play.api.Play.current
import play.api.mvc.Action
import play.api.mvc.Controller

object JsMessagesController extends Controller with JsMessagesController

trait JsMessagesController {
  this: Controller =>

  val messages = JsMessages.default

  val jsMessages = Action { implicit request =>
    Ok(messages.all(Some("window.Messages")))
  }

}