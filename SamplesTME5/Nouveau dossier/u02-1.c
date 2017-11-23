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
    ILP_Object ilptmp1;
    {
      ILP_Object ilptmp2;
      {
	ILP_Object ilptmp3;
	ilptmp3 = ILP_Integer2ILP (0);
	ilptmp2 = (x = ilptmp3);
      }
      while (1)
	{
	  ILP_Object ilptmp4;
	  {
	    ILP_Object ilptmp5;
	    ILP_Object ilptmp6;
	    ilptmp5 = x;
	    ilptmp6 = ILP_Integer2ILP (5);
	    ilptmp4 = ILP_LessThan (ilptmp5, ilptmp6);
	  }
	  if (ILP_isEquivalentToTrue (ilptmp4))
	    {
	      {
		ILP_Object ilptmp7;
		{
		  ILP_Object ilptmp8;
		  ILP_Object ilptmp9;
		  ilptmp8 = x;
		  ilptmp9 = ILP_Integer2ILP (2);
		  ilptmp7 = ILP_LessThan (ilptmp8, ilptmp9);
		}
		if (ILP_isEquivalentToTrue (ilptmp7))
		  {
		    {
		      ILP_Object ilptmp10;
		      {
			ILP_Object ilptmp11;
			ILP_Object ilptmp12;
			ilptmp11 = x;
			ilptmp12 = ILP_Integer2ILP (1);
			ilptmp10 = ILP_Plus (ilptmp11, ilptmp12);
		      }
		      (void) (x = ilptmp10);
		    }

		  }
		else
		  {
		    (void) ILP_FALSE;

		  }
	      }

	    }
	  else
	    {
	      break;

	    }
	}
      ilptmp2 = ILP_FALSE;
      {
	ILP_Object ilptmp13;
	{
	  ILP_Object ilptmp14;
	  ilptmp14 = ILP_Integer2ILP (20);
	  ilptmp13 = (x = ilptmp14);
	}
	continue;
	ilptmp2 = ilptmp13;
      }
      ilptmp1 = ilptmp2;
    }
    {
      ILP_Object ilptmp15;
      ilptmp15 = x;
      ilptmp1 = ILP_print (ilptmp15);
    }
    return ilptmp1;
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
