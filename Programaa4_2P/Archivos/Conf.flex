package fes.aragon.utilerias;
import static fes.aragon.utilerias.Tokens.*;

%%

%class Analizador
%type Tokens
%unicode

/* Comments */
startComment = \{
endComment = \}
contentComment= [^}]*
Comment = {startComment}{contentComment}{endComment}

UnicodeLetter  = [:letter:]
UnicodeDigit   = [:digit:]
Letter         = {UnicodeLetter}|"_"


/* White spaces*/
LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]


%%


	/* Reserved Words */
	";"                      	{ return PUNTOCOMA; }
	"+"						   	{ return SUM; }
	"*"							{ return POR; }
	"("							{ return P_ABRE; }
	")"							{ return P_CIERRA; }
	

    /* White spaces */
    {WhiteSpace}				    { /*Ignore*/ }

    /*Identificadores*/
    [A-Za-z_][A-Za-z_0-9]*			{ return IDENTIFICADOR; }