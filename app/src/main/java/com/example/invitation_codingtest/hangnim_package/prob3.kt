
fun main(args : Array<String>){


//    fun possiblechecker(lastnum : Int, aa: Int, bb: Int, cc: Int) : Boolean
//    {
//        if()
//
//    }


    fun solution(A: Int, B: Int, C: Int): String {

        //** 일단, 숫자로 생각
        //step 1. 가장 많은 문자 셀렉트
        //step 2. 스탭1을 제외한 문자를 셀렉트
        //step 3. 스탭 2의 문자를 제외한 가장많은 비트를 셀렉트
        //step 4. 반복후 불가능에 봉착하면 리턴.

        var aa = A
        var bb = B
        var cc = C
        val sb = StringBuilder()
        var lastbit = 0 //a = 1 / b = 2 /  c = 3

        while(true)
        {
            //최대수를 뽑아냄
            if(aa >= bb && aa >= cc) // A most
            {
                if (lastbit != 1) {
                    if (aa >= 2) //반대로 2보다 작은경우면 abc가 111 아래.
                    {
                        aa = aa - 2
                        sb.append("aa")
                        if (bb >= cc) {
                            if (bb >= 1) //값이 있다면,
                            {
                                bb--
                                sb.append("b")
                                lastbit = 2
                            } else //bb가 값이 없으면 여분의 수가 없음
                            {
                                break
                            }
                        } else //cc가 큰경우
                        {
                            if (cc >= 1) //값이 있다면,
                            {
                                cc--
                                sb.append("c")
                                lastbit = 3
                            } else //bb가 값이 없으면 여분의 수가 없음
                            {
                                break
                            }
                        }
                        //붙이고 나서 다음 수 아무거나 한개 붙이고 그것을 기억
                    }
                    else if(aa == 1)
                    {
                        aa--
                        sb.append("a")
                        lastbit = 1
                    }
                    else //최대수가 0인 경우 break
                        break
                }
                else
                {
                    if(aa > 0 && (cc > 0 || bb > 0))
                    {
                        aa--
                        sb.append("a")
                        lastbit = 1
                    }
                    else  break
                }

            }
            else if(bb >= aa && bb >= cc) // B most
            {
                if (lastbit != 2) {
                    if (bb >= 2) //반대로 2보다 작은경우면 abc가 111 아래.
                    {
                        bb = bb - 2
                        sb.append("bb")
                        if (aa >= cc) {
                            if (aa >= 1) //값이 있다면,
                            {
                                aa--
                                sb.append("a")
                                lastbit = 1
                            } else //bb가 값이 없으면 여분의 수가 없음
                            {
                                break
                            }
                        } else //cc가 큰경우
                        {
                            if (cc >= 1) //값이 있다면,
                            {
                                cc--
                                sb.append("c")
                                lastbit = 3
                            } else //bb가 값이 없으면 여분의 수가 없음
                            {
                                break
                            }
                        }
                        //붙이고 나서 다음 수 아무거나 한개 붙이고 그것을 기억
                    }
                    else if(bb == 1)
                    {
                        bb--
                        sb.append("b")
                        lastbit = 2
                    }
                    else //최대수가 0인 경우 break
                        break
                }
                else
                {
                    if(bb > 0 && (cc > 0 || aa > 0))
                    {
                        bb--
                        sb.append("b")
                        lastbit = 2
                    }
                    else  break
                }
            }
            else if(cc >= aa && cc >= bb) // C most
            {
                if (lastbit != 3) {
                    if (cc >= 2) //반대로 2보다 작은경우면 abc가 111 아래.
                    {
                        cc = cc - 2
                        sb.append("cc")
                        if (aa >= bb) {
                            if (aa >= 1) //값이 있다면,
                            {
                                aa--
                                sb.append("a")
                                lastbit = 1
                            } else //bb가 값이 없으면 여분의 수가 없음
                            {
                                break
                            }
                        } else //bb가 큰경우
                        {
                            if (bb >= 1)
                            {
                                bb--
                                sb.append("b")
                                lastbit = 2
                            } else
                            {
                                break
                            }
                        }
                        //붙이고 나서 다음 수 아무거나 한개 붙이고 그것을 기억
                    }
                    else if(cc == 1)
                    {
                        cc--
                        sb.append("c")
                        lastbit = 3
                    }
                    else //최대수가 0인 경우 break
                        break
                }
                else //aa가 젤 큰데 포인트가 a이면 브레이크
                {
                    if(cc > 0 && (bb > 0 || aa > 0))
                    {
                        cc--
                        sb.append("c")
                        lastbit = 3
                    }
                    else  break
                }
            }
        }

        val sbcheck = sb.toString()
        return sbcheck

    }

    println("1 : "+solution(0,1,0))
    println("2 : "+solution(1,0,0))
    println("3 : "+solution(0,0,1))
    println("4 : "+solution(10,5,2))
    println("5 : "+solution(30,10,0))
    println("6 : "+solution(50,15,10))
    println("7 : "+solution(0,5,10))
    println("8 : "+solution(10,5,15))
    println("9 : "+solution(12,5,20))
    println("10 : "+solution(30,15,50))
    println("11 : "+solution(31,14,37))
    println("12 : "+solution(33,11,43))




}