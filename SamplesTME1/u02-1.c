#include <stdio.h>
#include <stdlib.h>
#include "ilp.h"

/* Global variables */
ILP_Object print;


ILP_Object
ilp_program ()
{
  {
    ILP_Object ilptmp22;
    ilptmp22 = ILP_Integer2ILP (2);

    {
      ILP_Object a1 = ilptmp22;
      {
	ILP_Object ilptmp23;
	ilptmp23 = ILP_Integer2ILP (4);

	{
	  ILP_Object b2 = ilptmp23;
	  {
	    ILP_Object ilptmp24;
	    ilptmp24 = ILP_Integer2ILP (2);

	    {
	      ILP_Object c3 = ilptmp24;
	      {
		ILP_Object ilptmp25;
		{
		  ILP_Object ilptmp26;
		  ILP_Object ilptmp27;
		  {
		    ILP_Object ilptmp28;
		    ILP_Object ilptmp29;
		    ilptmp28 = b2;
		    ilptmp29 = b2;
		    ilptmp26 = ILP_Times (ilptmp28, ilptmp29);
		  }
		  {
		    ILP_Object ilptmp30;
		    ILP_Object ilptmp31;
		    {
		      ILP_Object ilptmp32;
		      ILP_Object ilptmp33;
		      ilptmp32 = ILP_Integer2ILP (4);
		      ilptmp33 = a1;
		      ilptmp30 = ILP_Times (ilptmp32, ilptmp33);
		    }
		    ilptmp31 = c3;
		    ilptmp27 = ILP_Times (ilptmp30, ilptmp31);
		  }
		  ilptmp25 = ILP_Minus (ilptmp26, ilptmp27);
		}

		{
		  ILP_Object delta4 = ilptmp25;
		  {
		    ILP_Object ilptmp34;
		    {
		      ILP_Object ilptmp35;
		      ILP_Object ilptmp36;
		      ilptmp35 = delta4;
		      ilptmp36 = ILP_Integer2ILP (0);
		      ilptmp34 = ILP_Equal (ilptmp35, ilptmp36);
		    }
		    if (ILP_isEquivalentToTrue (ilptmp34))
		      {
			{
			  ILP_Object ilptmp37;
			  ilptmp37 =
			    ILP_String2ILP
			    ("discriminant nul: une seule racine");
			  return ILP_print (ilptmp37);
			}

		      }
		    else
		      {
			{
			  ILP_Object ilptmp38;
			  {
			    ILP_Object ilptmp39;
			    ILP_Object ilptmp40;
			    ilptmp39 = delta4;
			    ilptmp40 = ILP_Integer2ILP (0);
			    ilptmp38 = ILP_LessThan (ilptmp39, ilptmp40);
			  }
			  if (ILP_isEquivalentToTrue (ilptmp38))
			    {
			      {
				ILP_Object ilptmp41;
				ilptmp41 =
				  ILP_String2ILP
				  ("discriminant negatif: aucune racine");
				return ILP_print (ilptmp41);
			      }

			    }
			  else
			    {
			      {
				ILP_Object ilptmp42;
				ilptmp42 =
				  ILP_String2ILP
				  ("discriminant positif: deux racines");
				return ILP_print (ilptmp42);
			      }

			    }
			}

		      }
		  }

		}
	      }

	    }
	  }

	}
      }

    }
  }

}

static ILP_Object
ilp_caught_program ()
{
  struct ILP_catcher *current_catcher = ILP_current_catcher;
  struct ILP_catcher new_catcher;

  if (0 == setjmp (new_catcher._jmp_buf))
    {
      ILP_establish_catcher (&new_catcher);
      return ilp_program ();
    };
  return ILP_current_exception;
}

int
main (int argc, char *argv[])
{
  ILP_START_GC;
  ILP_print (ilp_caught_program ());
  ILP_newline ();
  return EXIT_SUCCESS;
}
