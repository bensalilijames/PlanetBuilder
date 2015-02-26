#if __VERSION__ >= 130
	#define varying in
	out vec4 mgl_FragColor;
	#define texture2D texture
	#define gl_FragColor mgl_FragColor
#endif

#ifdef GL_ES
	precision mediump float;
	precision mediump int;
#endif

varying vec4 varying_Color;

void main (void)
{
    gl_FragColor = varying_Color;
}