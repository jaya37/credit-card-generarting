import React, { useState } from 'react'
import WelcomeBank from './WelcomeBank';
import AccountRequests from './AccountRequests';
import BankProfile from './BankProfile';
import BankCardRequests from './BankCardRequests';

const BankSideNav = () => {
    const [data, setData] = useState("userHome");
  return (
    <div>
        <h2 className='text-dark'>Bank Page</h2>
         <div className=" px-md-1 px-sm-0 mb-2 text-dark py-md-1 py-sm-0">
            <div className="">
                <div className=" py-md-2 bg-primary ">
                    <div className="px-md-3 px-sm-0">
                        <div className="row flex-nowrap">

                            <div
                                className="col-auto col-md-3 col-xl-2 px-sm-1 px-0  text-dark  "
                                style={{ backgroundColor: "rgb(255,243,205)" }}
                            >
                                <div className="d-flex flex-column align-items-center align-items-sm-start px-1 pt-2  text-dark min-vh-100">
                                    {/* <a
                      href="#"
                      className="d-flex align-items-center pb-3 mb-md-0 me-md-auto text-primary text-decoration-none"
                    > */}
                                    <span className="fs-5 mt-5 mb-5 d-none d-sm-inline text-dark">
                                        WELCOME
                                    </span>
                                    {/* </a> */}
                                    <ul
                                        className="nav nav-pills flex-column   text-dark mb-sm-auto mb-0 align-items-center align-items-sm-start"
                                        id="menu"
                                    >
                                        <li className="nav-item text-dark">
                                            <button
                                                onClick={() => setData("userHome")}
                                                className="nav-link align-middle px-0"
                                            >
                                                <img
                                                    src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIIAAACCCAMAAAC93eDPAAAAe1BMVEUVl9H////z8/P39/fy8vL+/v74+Pj7+/vn5+ft7e3h4eHi4uLk5OTq6uoAlNAAks9/ud/Q5vMAiMsAjs7j7/hWqNir0+r9+PW00+iKv+HH3ex0t945ndLs8vXa4eX18e5qsNqiy+fI1+GmyeCVwNvZ5vC3z+DA2u4AgMmZoSFUAAAHj0lEQVR4nM1bjZKrLAwFUZEq0F619ker23Z3v/d/wg+su9da+bO0czPTmTLZwtkkBo4kAEKaxTDMCIyyJIJJhmAgBjhJ36RJwJ0Kj1TZmzQJoBThkAYYUYJjQmNMaNgP8Ls0IMswJKsAolUCo2QVQZqGMF5RCFdv0oA4DgmKAxLGiIgvhAQ/g3dpZCyshI9S4aOVDJNU+EgMcLZ6kyYDYRgEwe8nvH1GX16vucVCKnyUSh+lESSZ8FH64703aIBwDApJgAL5hVDxISEKqBjQN2n+hViIIpKgKEhIhBOKIR0GcSLs9R7NNC9A5ZM8o4mFX6HUEPvfPGpAksQCXxChhEaYJlgMQjEgOEqoRgPbtoLN6VQUp1PT0KSClfif9L9RaECEpYHCwUDRr4FootRQiOlpd+3KWggAoK7LstvvikZoItfZbttUHybSVjJMViJMVncBNNHA5GtfsjznjIFfYYzzP6xcb2CbOc0mw3HkCDgYSA6I+KtHDYLNpZSrg1lhAlm5S1oErWa7aaJJahLbx31ojTVt9t0B1fK/MDjoDhCbZ/vVAJknApE0huxB+uwRDtljpIlbcqlzw/oDCmGKABPdbCNNv02lw1EifUgmfzUQXkFus/4AAmwpVc92n5qsdpIg2AoDOwkHO4SsdiyrWCCb0hFAD6I8T5PWfCzI80PYnx/I7TAhB0gcJuK/g71dDEyF5R/4YbbHdUZ5IZp/kttDvcAEgyHA52NeiKZ5AYtzpDxYikMlJXE/CPqDJb1pqv1iANIQbFuNZ5tbR6Qm4aNM+ChLRMrIhqNEJnwkz9phenwGgZB8H/3ONr8OSB92sNUogJrlTvgR3qF0dqf8WecnFlZzWZ2cTbnQRhhrot9YeFwnvWNTdMJ/Dh4ASAygoJlyHR2bIgfgBwJgdREtYlNn5gmBxNCkC9hU83QgjjEA5M6m0tKbDXoMXeTKpqpn88FU8n3lxqbap3LiPIatE5tCZ+8IRI76dGJTtX8E4rHA9myK+HeDFP4BbdkU2tgf0YDLaYqfrdmUw/PI6q09BlZWdmwKukwKCniw/3P+RW3YVAwdEPAGwhEG1hW9fCinaIkFm3JICbyWCCDc/DiOrfsx3Ko8ybfYhk3ZAhAIituKcMMtIYDagk21F9vHgQ02GGEwQ8h32MimMtusxOsYwgkGMwRWGtkU+rY0Ai8bOJZP1i+ADRBAvkEGNgU7u5wwRSAwSDvwDhsg8GNrYFONrQ0wnMqAwQAB1NTApi5WTyQvowcEEBbyrMlLAwR+yLRsClrlZn58tMENA5DxEOshHFstm0psgnFw+Iw0kncItQ4C4DDSsCn6ZQGhN7VCCtb7QgshL6CGTUGL5MyPagTCDjIe9Bs4u1IdmzKHQr6ei8QJBq2wjkZqNkWNRuBrLQCJwciA6kDNpuDZFAq51guWdvjTqNlUuzNYId+bEUDjG4H8O1ayKdNRwQ6BxKC1gzjGKtlUpd8guCUCEwa2rtRsSvtA2NpASqx7S8i6VsWm4kZ3VpDm84OBlbeXwzNsKj1pIOROCCDEGl+IXUTFpjQQXLww2EH9XIgTn4pNFUoEbl4Y7KD0RX1SsSk1hHznjkCDoT4p2dRJhWC7BIEaw8QRYzalgMAX2aCX+UQjIKjYVDEbjuz4vdvtLq6rFzspszMOjphjU4q8wLiQ/1whbHL5s9kJyyxVsClCy3lPSPnjDEFDZ2I1m9IkaJ8QOqhkU7ptyiMEfv/+7y4WdEdHnxC2rZJNVZr3Kx4h5IdQyaZooT64+YSQadhU85ZYqDVsKtI8Ev4gsKOWTe3fAEHsujo2dVAGwwyEYiwPBEcJIT/r7qYi6AJhnM4f3zeordBqK/1aZTDMQBhpmT0EwUm1d1OZMjP4g/BluJtKFAj8QahNd1OtapvwBUHwIcPdFFI9E94gfJrupsR577UQysR4N1V9zJvBE4T82+JuSvHm0ROEurW4m8Ifs7/1A4FfWou7KUJfB4HVdndTdPYNrBcI/AAtK/3msrQPCKxDlpV+aO6tF9+vJ7Ifq+updt3NzFEEtpV+8DrjCvYgLmop+YXaV/phX/UbdyDL1qXSb+NwB2sN4YScKv0UOfIJ4ZfErdLvuaKuGcmvlWuln/o1zSLhXeJe6Rf6K+iRaTFcUOmXmV/rOyA4Lar0iz79lVadFlb6UU8YehssrPSLzNcbFsKFDRZX+tEUdU8/F3kXjqo+XSv9hCbaP5mj+DV56JuyrvS7aartM85gfFd56Jv6XF75mZenxEvfFP5YWIQsTorIU98UPC/I1ox3BfXXN4XQF3AtSK8PKFDsgcv6pmi7tewL6CWvL/L1pt++KYKDXZnbVTfw8rttX9I3heHG3KLBeb3/TF7XN4Va+t3xXJUpGMv58QvN1vN57JvKWvh57eo/sl2H/V2b8zyvjx/nFr6jb0pkFRo0h+u6K/u2pVvP0vaQ3TflvLRvKpHOi2HVkriRjVunExKD0PAbj31T90lLlhz0oWX7m2f7pl6hceqbepHGum/qZRrrvqnXaSz7pl6q+Rdiwdw39WqNuW/q1Rpz39TrNfdsKpn2Tb1DM7keG6vSN2n+By+NHA2Rrsj2AAAAAElFTkSuQmCC"
                                                    alt="hugenerd"
                                                    width="30"
                                                    height="30"
                                                    className="rounded-circle"
                                                />{" "}
                                                <h6 className="ms-1 d-none d-sm-inline text-dark">
                                                    HOME
                                                </h6>
                                            </button>
                                        </li>
                                        <li>
                                            <button
                                                onClick={() => setData("profile")}
                                                className="nav-link px-0 align-middle"
                                            >
                                                <img
                                                    src="data:image/jpeg;base64,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"
                                                    alt="hugenerd"
                                                    width="30"
                                                    height="30"
                                                    className="rounded-circle"
                                                />{" "}
                                                <h6 className="ms-1 d-none d-sm-inline  text-dark">
                                                   UPDATE PROFILE                                               </h6>
                                            </button>
                                        </li>
                                        <li>
                                            <button
                                                data-bs-toggle="collapse"
                                                className="nav-link px-0 align-middle"
                                                onClick={() => setData("accountrequests")}
                                            >
                                                <img
                                                    src="data:image/jpeg;base64,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"
                                                    alt="hugenerd"
                                                    width="30"
                                                    height="30"
                                                    className="rounded-circle"
                                                />{" "}
                                                <h6 className="ms-1 d-none d-sm-inline  text-dark">
                                                     USERS ACCOUNT REQUEST
                                                </h6>{" "}
                                            </button>
                                        </li>
                                        
                                        <li>
                                            <button
                                                onClick={() => setData("cardrequests")}
                                                data-bs-toggle="collapse"
                                                className="nav-link px-0 align-middle "
                                            >
                                                <img
                                                    src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGhKyKDQ68AbQGjmw-6be5Gjw2uBV2qSVS2b1S9GC_2w&s"
                                                    alt="hugenerd"
                                                    width="20"
                                                    height="20"
                                                    className="rounded-circle"
                                                />
                                                <h6 className="ms-1 d-none d-sm-inline  text-dark">
                                                    CARD REQUESTS
                                                </h6>
                                            </button>
                                        </li>
                                  
                                  

                                    </ul>
                                    <hr />
                                    <div className="pb-5">
                                        <span className="d-none d-sm-inline mx-1 text-dark">
                                            @2023 allrights reserved
                                        </span>
                                    </div>
                                </div>
                            </div>
                            {data === "userHome" && <WelcomeBank />}
                            {data === "accountrequests" && <AccountRequests />}
                            {data === "profile" && <BankProfile />}
                            {data === "cardrequests" && <BankCardRequests />}
                        </div></div>
                </div>
            </div>
        </div>  
    </div>
  )
}

export default BankSideNav;