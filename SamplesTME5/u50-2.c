#include <stdio.h>
#include <stdlib.h>
#include "ilp.h"

/* Global variables */
ILP_Object print;
ILP_Object x;

/* Global prototypes */

/* Global functions */


ILP_Object
ilp_program ()
{
  {
    ILP_Object ilptmp15;
    {
      ILP_Object ilptmp16;
      {
	ILP_Object ilptmp17;
	ilptmp17 = ILP_Integer2ILP (0);
	ilptmp16 = (x = ilptmp17);
      }
      while (1)
	{
	  ILP_Object ilptmp18;
	  {
	    ILP_Object ilptmp19;
	    ILP_Object ilptmp20;
	    ilptmp19 = x;
	    ilptmp20 = ILP_Integer2ILP (20);
	    ilptmp18 = ILP_LessThan (ilptmp19, ilptmp20);
	  }
	  if (ILP_isEquivalentToTrue (ilptmp18))
	    {
	      {
		ILP_Object ilptmp21;
		{
		  ILP_Object ilptmp22;
		  ILP_Object ilptmp23;
		  ilptmp22 = x;
		  ilptmp23 = ILP_Integer2ILP (10);
		  ilptmp21 = ILP_LessThan (ilptmp22, ilptmp23);
		}
		if (ILP_isEquivalentToTrue (ilptmp21))
		  {
		    {
		      ILP_Object ilptmp24;
		      {
			ILP_Object ilptmp25;
			ILP_Object ilptmp26;
			ilptmp25 = x;
			ilptmp26 = ILP_Integer2ILP (1);
			ilptmp24 = ILP_Plus (ilptmp25, ilptmp26);
		      }
		      (void) (x = ilptmp24);
		    }

		  }
		else
		  {
		    break;
		  }
	      }

	    }
	  else
	    {
	      break;

	    }
	}
      ilptmp16 = ILP_FALSE;
      ilptmp15 = ilptmp16;
    }
    {
      ILP_Object ilptmp27;
      ilptmp27 = x;
      ilptmp15 = ILP_print (ilptmp27);
    }
    return ilptmp15;
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
