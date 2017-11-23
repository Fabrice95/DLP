#include <stdio.h>
#include <stdlib.h>
#include "ilp.h"

/* Global variables */
ILP_Object print;

/* Global prototypes */

/* Global functions */


ILP_Object
ilp_program ()
{
  {
    ILP_Object ilptmp1;
    ilptmp1 = ILP_Integer2ILP (5);

    {
      ILP_Object x1 = ilptmp1;
      {
	ILP_Object ilptmp2;
	while (1)
	  {
	    ILP_Object ilptmp3;
	    {
	      ILP_Object ilptmp4;
	      ILP_Object ilptmp5;
	      ilptmp4 = x1;
	      ilptmp5 = ILP_Integer2ILP (3);
	      ilptmp3 = ILP_GreaterThan (ilptmp4, ilptmp5);
	    }
	    if (ILP_isEquivalentToTrue (ilptmp3))
	      {
		{
		  ILP_Object ilptmp6;
		  {
		    ILP_Object ilptmp7;
		    ILP_Object ilptmp8;
		    ilptmp7 = x1;
		    ilptmp8 = ILP_Integer2ILP (4);
		    ilptmp6 = ILP_Equal (ilptmp7, ilptmp8);
		  }
		  if (ILP_isEquivalentToTrue (ilptmp6))
		    {
		      {
			ILP_Object ilptmp9;
			{
			  ILP_Object ilptmp10;
			  ilptmp10 = ILP_Integer2ILP (0);
			  ilptmp9 = (x1 = ilptmp10);
			}
			continue;
			(void) ilptmp9;
		      }

		    }
		  else
		    {
		      {
			ILP_Object ilptmp11;
			{
			  ILP_Object ilptmp12;
			  ILP_Object ilptmp13;
			  ilptmp12 = x1;
			  ilptmp13 = ILP_Integer2ILP (1);
			  ilptmp11 = ILP_Minus (ilptmp12, ilptmp13);
			}
			(void) (x1 = ilptmp11);
		      }

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
	  ILP_Object ilptmp14;
	  ilptmp14 = x1;
	  ilptmp2 = ILP_print (ilptmp14);
	}
	return ilptmp2;
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
