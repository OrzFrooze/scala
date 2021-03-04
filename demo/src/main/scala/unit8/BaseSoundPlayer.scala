package unit8

trait BaseSoundPlayer {
  def play

  def pause

  def stop

  def resume

  def close

  def withParam(param: String)
}


class Mp3SoundPlay extends BaseSoundPlayer{
  override def play: Unit = ???

  override def pause: Unit = ???

  override def stop: Unit = ???

  override def resume: Unit = ???

  override def close: Unit = ???

  override def withParam(param: String): Unit = ???
}