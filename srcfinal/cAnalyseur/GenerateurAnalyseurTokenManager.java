/* Generated By:JJTree&JavaCC: Do not edit this line. GenerateurAnalyseurTokenManager.java */
package cAnalyseur;

/** Token Manager. */
public class GenerateurAnalyseurTokenManager implements GenerateurAnalyseurConstants
{

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x3fffe2680L) != 0L)
         {
            jjmatchedKind = 5;
            return -1;
         }
         return -1;
      case 1:
         if ((active0 & 0x3fffe2680L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 5;
               jjmatchedPos = 0;
            }
            return -1;
         }
         return -1;
      case 2:
         if ((active0 & 0x3fffe2680L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 5;
               jjmatchedPos = 0;
            }
            return -1;
         }
         return -1;
      case 3:
         if ((active0 & 0x3fffe2680L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 5;
               jjmatchedPos = 0;
            }
            return -1;
         }
         return -1;
      case 4:
         if ((active0 & 0x3fffe2680L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 5;
               jjmatchedPos = 0;
            }
            return -1;
         }
         return -1;
      case 5:
         if ((active0 & 0x3fffe2680L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 5;
               jjmatchedPos = 0;
            }
            return -1;
         }
         return -1;
      case 6:
         if ((active0 & 0x3fffe2680L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 5;
               jjmatchedPos = 0;
            }
            return -1;
         }
         return -1;
      case 7:
         if ((active0 & 0x3ffee2680L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 5;
               jjmatchedPos = 0;
            }
            return -1;
         }
         return -1;
      case 8:
         if ((active0 & 0x3ffe42680L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 5;
               jjmatchedPos = 0;
            }
            return -1;
         }
         return -1;
      case 9:
         if ((active0 & 0x3f6e42600L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 5;
               jjmatchedPos = 0;
            }
            return -1;
         }
         return -1;
      case 10:
         if ((active0 & 0x386402000L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 5;
               jjmatchedPos = 0;
            }
            return -1;
         }
         return -1;
      case 11:
         if ((active0 & 0x386402000L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 5;
               jjmatchedPos = 0;
            }
            return -1;
         }
         return -1;
      case 12:
         if ((active0 & 0x386002000L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 5;
               jjmatchedPos = 0;
            }
            return -1;
         }
         return -1;
      case 13:
         if ((active0 & 0x384002000L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 5;
               jjmatchedPos = 0;
            }
            return -1;
         }
         return -1;
      case 14:
         if ((active0 & 0x200002000L) != 0L)
         {
            if (jjmatchedPos == 0)
            {
               jjmatchedKind = 5;
               jjmatchedPos = 0;
            }
            return -1;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 40:
         return jjStopAtPos(0, 11);
      case 41:
         return jjStopAtPos(0, 8);
      case 44:
         return jjStopAtPos(0, 12);
      case 60:
         return jjMoveStringLiteralDfa1_0(0x8000000000L);
      case 61:
         return jjStopAtPos(0, 34);
      case 80:
         return jjMoveStringLiteralDfa1_0(0x4000L);
      case 82:
         return jjMoveStringLiteralDfa1_0(0x10000L);
      case 84:
         return jjMoveStringLiteralDfa1_0(0x8000L);
      case 86:
         return jjStopAtPos(0, 35);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x1fe0000L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x78000680L);
      case 109:
         return jjMoveStringLiteralDfa1_0(0x206002000L);
      case 112:
         return jjMoveStringLiteralDfa1_0(0x180000000L);
      case 172:
         return jjStopAtPos(0, 37);
      case 8658:
         return jjStopAtPos(0, 38);
      case 8704:
         return jjStopAtPos(0, 40);
      case 8707:
         return jjStopAtPos(0, 41);
      case 8743:
         return jjStopAtPos(0, 36);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 61:
         return jjMoveStringLiteralDfa2_0(active0, 0x8000000000L);
      case 95:
         return jjMoveStringLiteralDfa2_0(active0, 0x660000L);
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x206002000L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x180000000L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x10000L);
      case 115:
         return jjMoveStringLiteralDfa2_0(active0, 0x78000680L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x1988000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 62:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStopAtPos(2, 39);
         break;
      case 95:
         return jjMoveStringLiteralDfa3_0(active0, 0x1980000L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x668000L);
      case 109:
         return jjMoveStringLiteralDfa3_0(active0, 0x206002000L);
      case 113:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x10000L);
      case 116:
         return jjMoveStringLiteralDfa3_0(active0, 0x78000680L);
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x180000000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 95:
         return jjMoveStringLiteralDfa4_0(active0, 0x78660680L);
      case 101:
         return jjMoveStringLiteralDfa4_0(active0, 0x206012000L);
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000L);
      case 110:
         return jjMoveStringLiteralDfa4_0(active0, 0x880000L);
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x181100000L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 40:
         if ((active0 & 0x10000L) != 0L)
            return jjStopAtPos(4, 16);
         break;
      case 95:
         return jjMoveStringLiteralDfa5_0(active0, 0x386002000L);
      case 98:
         return jjMoveStringLiteralDfa5_0(active0, 0x200L);
      case 101:
         return jjMoveStringLiteralDfa5_0(active0, 0x8224000L);
      case 103:
         return jjMoveStringLiteralDfa5_0(active0, 0x20000000L);
      case 109:
         return jjMoveStringLiteralDfa5_0(active0, 0x40000000L);
      case 111:
         return jjMoveStringLiteralDfa5_0(active0, 0xcc0000L);
      case 112:
         return jjMoveStringLiteralDfa5_0(active0, 0x10008000L);
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x480L);
      case 117:
         return jjMoveStringLiteralDfa5_0(active0, 0x1100000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa6_0(active0, 0x2000L);
      case 100:
         return jjMoveStringLiteralDfa6_0(active0, 0x1100000L);
      case 101:
         return jjMoveStringLiteralDfa6_0(active0, 0x10008000L);
      case 103:
         return jjMoveStringLiteralDfa6_0(active0, 0x100000000L);
      case 108:
         return jjMoveStringLiteralDfa6_0(active0, 0x6000200L);
      case 110:
         return jjMoveStringLiteralDfa6_0(active0, 0x8000000L);
      case 111:
         return jjMoveStringLiteralDfa6_0(active0, 0x40000480L);
      case 112:
         return jjMoveStringLiteralDfa6_0(active0, 0x80000000L);
      case 114:
         return jjMoveStringLiteralDfa6_0(active0, 0x20884000L);
      case 115:
         return jjMoveStringLiteralDfa6_0(active0, 0x220000L);
      case 116:
         return jjMoveStringLiteralDfa6_0(active0, 0x200000000L);
      case 117:
         return jjMoveStringLiteralDfa6_0(active0, 0x440000L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 40:
         if ((active0 & 0x8000L) != 0L)
            return jjStopAtPos(6, 15);
         else if ((active0 & 0x100000L) != 0L)
            return jjStopAtPos(6, 20);
         break;
      case 95:
         return jjMoveStringLiteralDfa7_0(active0, 0x1000000L);
      case 97:
         return jjMoveStringLiteralDfa7_0(active0, 0x222000200L);
      case 100:
         return jjMoveStringLiteralDfa7_0(active0, 0x880000L);
      case 101:
         return jjMoveStringLiteralDfa7_0(active0, 0x80444000L);
      case 111:
         return jjMoveStringLiteralDfa7_0(active0, 0x4002000L);
      case 114:
         return jjMoveStringLiteralDfa7_0(active0, 0x100000000L);
      case 115:
         return jjMoveStringLiteralDfa7_0(active0, 0x80L);
      case 116:
         return jjMoveStringLiteralDfa7_0(active0, 0x18220000L);
      case 117:
         return jjMoveStringLiteralDfa7_0(active0, 0x400L);
      case 121:
         return jjMoveStringLiteralDfa7_0(active0, 0x40000000L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 40:
         if ((active0 & 0x20000L) != 0L)
            return jjStopAtPos(7, 17);
         else if ((active0 & 0x80000L) != 0L)
            return jjStopAtPos(7, 19);
         break;
      case 95:
         return jjMoveStringLiteralDfa8_0(active0, 0xa00000L);
      case 97:
         return jjMoveStringLiteralDfa8_0(active0, 0x100000000L);
      case 100:
         return jjMoveStringLiteralDfa8_0(active0, 0x1000000L);
      case 101:
         return jjMoveStringLiteralDfa8_0(active0, 0x40000080L);
      case 103:
         return jjMoveStringLiteralDfa8_0(active0, 0x400L);
      case 105:
         return jjMoveStringLiteralDfa8_0(active0, 0x210000000L);
      case 110:
         return jjMoveStringLiteralDfa8_0(active0, 0x24000200L);
      case 114:
         return jjMoveStringLiteralDfa8_0(active0, 0x8000000L);
      case 115:
         return jjMoveStringLiteralDfa8_0(active0, 0x440000L);
      case 116:
         return jjMoveStringLiteralDfa8_0(active0, 0x82004000L);
      case 117:
         return jjMoveStringLiteralDfa8_0(active0, 0x2000L);
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
private int jjMoveStringLiteralDfa8_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 40:
         if ((active0 & 0x80L) != 0L)
            return jjStopAtPos(8, 7);
         break;
      case 99:
         return jjMoveStringLiteralDfa9_0(active0, 0x200L);
      case 100:
         return jjMoveStringLiteralDfa9_0(active0, 0x20a00000L);
      case 101:
         if ((active0 & 0x1000000L) != 0L)
            return jjStopAtPos(8, 24);
         else if ((active0 & 0x8000000L) != 0L)
            return jjStopAtPos(8, 27);
         return jjMoveStringLiteralDfa9_0(active0, 0x400L);
      case 103:
         return jjMoveStringLiteralDfa9_0(active0, 0x4000000L);
      case 105:
         return jjMoveStringLiteralDfa9_0(active0, 0x82000000L);
      case 108:
         return jjMoveStringLiteralDfa9_0(active0, 0x200002000L);
      case 110:
         return jjMoveStringLiteralDfa9_0(active0, 0x140000000L);
      case 116:
         return jjMoveStringLiteralDfa9_0(active0, 0x10444000L);
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
private int jjMoveStringLiteralDfa9_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(7, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(8, active0);
      return 9;
   }
   switch(curChar)
   {
      case 40:
         if ((active0 & 0x200L) != 0L)
            return jjStopAtPos(9, 9);
         else if ((active0 & 0x400L) != 0L)
            return jjStopAtPos(9, 10);
         else if ((active0 & 0x40000L) != 0L)
            return jjStopAtPos(9, 18);
         else if ((active0 & 0x10000000L) != 0L)
            return jjStopAtPos(9, 28);
         else if ((active0 & 0x20000000L) != 0L)
            return jjStopAtPos(9, 29);
         else if ((active0 & 0x40000000L) != 0L)
            return jjStopAtPos(9, 30);
         break;
      case 95:
         return jjMoveStringLiteralDfa10_0(active0, 0x400000L);
      case 100:
         return jjMoveStringLiteralDfa10_0(active0, 0x100000000L);
      case 101:
         if ((active0 & 0x200000L) != 0L)
            return jjStopAtPos(9, 21);
         else if ((active0 & 0x800000L) != 0L)
            return jjStopAtPos(9, 23);
         return jjMoveStringLiteralDfa10_0(active0, 0x6000L);
      case 105:
         return jjMoveStringLiteralDfa10_0(active0, 0x4000000L);
      case 108:
         return jjMoveStringLiteralDfa10_0(active0, 0x200000000L);
      case 116:
         return jjMoveStringLiteralDfa10_0(active0, 0x82000000L);
      default :
         break;
   }
   return jjStartNfa_0(8, active0);
}
private int jjMoveStringLiteralDfa10_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(8, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(9, active0);
      return 10;
   }
   switch(curChar)
   {
      case 40:
         if ((active0 & 0x4000L) != 0L)
            return jjStopAtPos(10, 14);
         break;
      case 95:
         return jjMoveStringLiteralDfa11_0(active0, 0x180000000L);
      case 100:
         return jjMoveStringLiteralDfa11_0(active0, 0x400000L);
      case 101:
         return jjMoveStringLiteralDfa11_0(active0, 0x200000000L);
      case 116:
         return jjMoveStringLiteralDfa11_0(active0, 0x4000000L);
      case 117:
         return jjMoveStringLiteralDfa11_0(active0, 0x2002000L);
      default :
         break;
   }
   return jjStartNfa_0(9, active0);
}
private int jjMoveStringLiteralDfa11_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(9, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(10, active0);
      return 11;
   }
   switch(curChar)
   {
      case 95:
         return jjMoveStringLiteralDfa12_0(active0, 0x200000000L);
      case 100:
         return jjMoveStringLiteralDfa12_0(active0, 0x2000000L);
      case 101:
         if ((active0 & 0x400000L) != 0L)
            return jjStopAtPos(11, 22);
         break;
      case 113:
         return jjMoveStringLiteralDfa12_0(active0, 0x180000000L);
      case 114:
         return jjMoveStringLiteralDfa12_0(active0, 0x2000L);
      case 117:
         return jjMoveStringLiteralDfa12_0(active0, 0x4000000L);
      default :
         break;
   }
   return jjStartNfa_0(10, active0);
}
private int jjMoveStringLiteralDfa12_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(10, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(11, active0);
      return 12;
   }
   switch(curChar)
   {
      case 95:
         return jjMoveStringLiteralDfa13_0(active0, 0x2000L);
      case 100:
         return jjMoveStringLiteralDfa13_0(active0, 0x4000000L);
      case 101:
         if ((active0 & 0x2000000L) != 0L)
            return jjStopAtPos(12, 25);
         break;
      case 113:
         return jjMoveStringLiteralDfa13_0(active0, 0x200000000L);
      case 117:
         return jjMoveStringLiteralDfa13_0(active0, 0x180000000L);
      default :
         break;
   }
   return jjStartNfa_0(11, active0);
}
private int jjMoveStringLiteralDfa13_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(11, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(12, active0);
      return 13;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x4000000L) != 0L)
            return jjStopAtPos(13, 26);
         else if ((active0 & 0x80000000L) != 0L)
            return jjStopAtPos(13, 31);
         else if ((active0 & 0x100000000L) != 0L)
            return jjStopAtPos(13, 32);
         break;
      case 113:
         return jjMoveStringLiteralDfa14_0(active0, 0x2000L);
      case 117:
         return jjMoveStringLiteralDfa14_0(active0, 0x200000000L);
      default :
         break;
   }
   return jjStartNfa_0(12, active0);
}
private int jjMoveStringLiteralDfa14_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(12, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(13, active0);
      return 14;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x200000000L) != 0L)
            return jjStopAtPos(14, 33);
         break;
      case 117:
         return jjMoveStringLiteralDfa15_0(active0, 0x2000L);
      default :
         break;
   }
   return jjStartNfa_0(13, active0);
}
private int jjMoveStringLiteralDfa15_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(13, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(14, active0);
      return 15;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x2000L) != 0L)
            return jjStopAtPos(15, 13);
         break;
      default :
         break;
   }
   return jjStartNfa_0(14, active0);
}
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 2;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x1ffffe00000000L & l) != 0L)
                  {
                     if (kind > 5)
                        kind = 5;
                  }
                  else if ((0x780000000000000L & l) != 0L)
                  {
                     if (kind > 6)
                        kind = 6;
                  }
                  break;
               case 1:
                  if ((0x780000000000000L & l) != 0L)
                     kind = 6;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (int)(curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 2 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, "\145\163\164\137\162\157\163\145\50", 
"\51", "\145\163\164\137\142\154\141\156\143\50", 
"\145\163\164\137\162\157\165\147\145\50", "\50", "\54", 
"\155\145\155\145\137\143\157\165\154\145\165\162\137\161\165\145", "\120\141\161\165\145\162\145\164\164\145\50", "\124\165\154\151\160\145\50", 
"\122\157\163\145\50", "\141\137\154\137\145\163\164\50", "\141\137\154\137\157\165\145\163\164\50", 
"\141\165\137\156\157\162\144\50", "\141\165\137\163\165\144\50", "\141\137\154\137\145\163\164\137\144\145", 
"\141\137\154\137\157\165\145\163\164\137\144\145", "\141\165\137\156\157\162\144\137\144\145", 
"\141\165\137\163\165\144\137\144\145", "\155\145\155\145\137\154\141\164\151\164\165\144\145", 
"\155\145\155\145\137\154\157\156\147\151\164\165\144\145", "\145\163\164\137\145\156\164\162\145", 
"\145\163\164\137\160\145\164\151\164\50", "\145\163\164\137\147\162\141\156\144\50", 
"\145\163\164\137\155\157\171\145\156\50", "\160\154\165\163\137\160\145\164\151\164\137\161\165\145", 
"\160\154\165\163\137\147\162\141\156\144\137\161\165\145", "\155\145\155\145\137\164\141\151\154\154\145\137\161\165\145", "\75", "\126", 
"\u2227", "\254", "\u21d2", "\74\75\76", "\u2200", "\u2203", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x3ffffffffe1L, 
};
static final long[] jjtoSkip = {
   0x1eL, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[2];
private final int[] jjstateSet = new int[4];
protected char curChar;
/** Constructor. */
public GenerateurAnalyseurTokenManager(SimpleCharStream stream){
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public GenerateurAnalyseurTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 2; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

}