package Render;

import window.Window;
import org.joml.Matrix4f;

import Graphics.ShaderProgram;

import static org.lwjgl.opengl.ARBVertexArrayObject.glBindVertexArray;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15C.GL_TRIANGLES;
import static org.lwjgl.opengl.GL15C.glClear;
import static org.lwjgl.opengl.GL15C.glDrawArrays;
import static org.lwjgl.opengl.GL15C.glViewport;
import static org.lwjgl.opengl.GL20.glBindBuffer;
import static org.lwjgl.opengl.GL20.glDeleteBuffers;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.glDeleteVertexArrays;

public class Render 
{
    static final float FOV = (float) Math.toRadians(60.0f);

    static final float ZNear = 0.01f;

    static final float ZFar = 1000.0f;

    int VboID;

    int VaoID;

    Matrix4f ProjectionMatrix;

    ShaderProgram shaderProgram;

    public void Init(Window window) throws Exception
    {
        shaderProgram = new ShaderProgram();
    }

    public void Clear()
    {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    public void render(Window window)
    {
        Clear();

        if (window.IsResized())
        {
            glViewport(0, 0, window.GetWidth(), window.GetHeight());

            window.SetResized(false);
        }

        shaderProgram.Bind();

        glBindVertexArray(VaoID);

        glDrawArrays(GL_TRIANGLES, 0, 3);

        glBindVertexArray(0);

        shaderProgram.UnBind();
    }

    public void CleanUp()
    {
        if (shaderProgram != null)
        {
            shaderProgram.Cleanup();
        }

        glDisableVertexAttribArray(0);

        glBindBuffer(GL_ARRAY_BUFFER, 0);

        glDeleteBuffers(VboID);

        glBindVertexArray(0);

        glDeleteVertexArrays(VaoID);
    }
}