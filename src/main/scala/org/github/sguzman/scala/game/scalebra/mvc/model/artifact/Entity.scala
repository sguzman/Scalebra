package org.github.sguzman.scala.game.scalebra.mvc.model.artifact

import org.lwjgl.opengl.GL11

/**
  * @author Salvador Guzman - sguzman
  * @group Scalebra
  * @version org.github.sguzman.scala.game.scalebra.mvc.model.artifact
  * @note This class represents all visualizable components to the game. This
  *       includes the snake and the food piece. Both of those will inherit from
  *       this class.
  * @since 5/6/16 8:00 PM
  */
abstract class Entity(r: Float, g: Float, b: Float, x: Float, y: Float) {
  /**
    * For this game, I will hard code several things values, like the size of all
    * artifacts.
    */
  val radius = 5.0f

  /**
    * Render the artifact.
    */
  def render(): Unit = {
    GL11.glPushMatrix()
    GL11.glTranslatef(x, y, 0)
    GL11.glTranslatef(-x, -y, 0)
    renderSq()
    GL11.glPopMatrix()
  }

  /**
    * Render four vertices
    */
  def renderSq(): Unit = {
    GL11.glBegin(GL11.GL_QUADS)
    GL11.glVertex2f(x - radius, y - radius)
    GL11.glVertex2f(x + radius, y - radius)
    GL11.glVertex2f(x + radius, y + radius)
    GL11.glVertex2f(x - radius, y + radius)
    GL11.glEnd()
  }

}
