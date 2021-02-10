package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet 
{

    public void settings() 
    {
        size(500, 500);
        cx = width / 2;
        cy = height / 2;        
    } // End settings()

    int mode = 0;

    float cx;
    float cy;

    public void keyPressed() 
    {
        // the value of mode will be the number of the 
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    } // End keypressed()

    public void setup() 
    {
        colorMode(HSB);
    } // End setup()

    public void draw() 
    {
        background(0);
        noStroke();
        switch (mode)
        {
            case 1:
                fill(50, 255, 255);                                    
                if (mouseX < cx && mouseY < cy)
                {
                    rect(0, 0, cx, cy);
                } // End if

                else if (mouseX > cx && mouseY < cy)
                {
                    rect(cx, 0, cx, cy);
                } // End else if

                else if (mouseX < cx && mouseY > cy)
                {
                    rect(0, cy, cx, cy);
                } // End else if

                else
                {
                    rect(cx, cy, cx, cy);
                } // End else
                break;

            
            case 2:
                int numRects = (int)(mouseX / 10.0f);
                float w = width / (float) numRects;
                float cgap = 255 / (float) numRects;

                for(int i = 0; i < numRects; i++)
                {
                    fill(i * cgap, 255, 255);
                    rect(i * w, 0, w, height);
                } // End for
                break;


            case 3:
                int numCircles = (int)(mouseX / 10.0f);
                w = width / (float) numCircles;
                cgap = 255 / (float) numCircles;
                for(int i = 0 ; i < numCircles ; i ++)
                {
                    fill(cgap * i, 255, 255);
                    ellipse(w / 2 + (i * w), cy, w, w);
                } // End for
                break;
                

            case 4:
                fill(255, 255, 255);
                stroke(255); 
                int numLines = 5;
                float theta = TWO_PI / (float) numLines;
                float radius = 100;
                for(int i = 0; i< numLines; i++)
                {
        
                    float angle = theta * i;
                    float x = sin(angle) * radius;
                    float y = cos(angle) * radius;
                    line(cx, cy, cx + x, cy + y);
                } // End for
                break;
                
        } // End Switch
    } // End draw()
} // End class

