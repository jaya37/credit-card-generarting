import React, { useState } from 'react'
import WelcomeUser from './WelcomeUser';
import AddAccount from './AddAccount';
import ViewBank from './ViewBank';
import ViewResponse from './ViewResponse';
import ViewAccount from './ViewAccount';
import CardResponse from './CardResponse';
import RaiseQuestion from './RaiseQuestion';


const UserSideNav = () => {
    const [data, setData] = useState("userHome");
    return (
        <div className=" px-md-1 px-sm-0 mb-2 text-dark py-md-1 py-sm-0">
            <h2 className='text-black'>User Page</h2>
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
                                                    src="data:image/png;base64,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"
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
                                                data-bs-toggle="collapse"
                                                className="nav-link px-0 align-middle"
                                                onClick={() => setData("addAccount")}
                                            >
                                                <img
                                                    src="data:image/jpeg;base64,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"
                                                    alt="hugenerd"
                                                    width="30"
                                                    height="30"
                                                    className="rounded-circle"
                                                />{" "}
                                                <h6 className="ms-1 d-none d-sm-inline  text-dark">
                                                    CREATE  ACCOUNT IN BANK
                                                </h6>{" "}
                                            </button>
                                        </li>
                                        <li>
                                            <button
                                                onClick={() => setData("billing")}
                                                data-bs-toggle="collapse"
                                                className="nav-link px-0 align-middle "
                                            >
                                                <img
                                                    src="data:image/png;base64,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"
                                                    alt="hugenerd"
                                                    width="20"
                                                    height="20"
                                                    className="rounded-circle"
                                                />
                                                <h6 className="ms-1 d-none d-sm-inline  text-dark">
                                                   VIEW  RESPOSNE
                                                </h6>
                                            </button>
                                        </li>
                                        <li>
                                            <button
                                                onClick={() => setData("viewaccount")}
                                                className="nav-link px-0 align-middle"
                                            >
                                                <img
                                                    src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRkB0_gyYvBctBejBlHBX39oPjkp7vy3pfSq3bP1Mp-4MSZm-1XHnh4uYDK5lcEk6IbFsY&usqp=CAU"
                                                    alt="hugenerd"
                                                    width="30"
                                                    height="30"
                                                    className="rounded-circle"
                                                />{" "}
                                                <h6 className="ms-1 d-none d-sm-inline  text-dark">
                                                    APPLY FOR CARD                                                </h6>
                                            </button>
                                        </li>
                                        <li>
                                            <button
                                                onClick={() => setData("partnerresponse")}
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
                                                    VIEW  RESPONSE OF CREDIT  PARTNERS
                                                </h6>
                                            </button>
                                        </li>
                                        <li>
                                            <button
                                                onClick={() => setData("riseQueires")}
                                                data-bs-toggle="collapse"
                                                className="nav-link px-0 align-middle "
                                            >
                                                <img
                                                    src="data:image/jpeg;base64,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"
                                                    alt="hugenerd"
                                                    width="30"
                                                    height="30"
                                                    className="rounded-circle"
                                                />
                                                <h6 className="ms-1 d-none d-sm-inline  text-dark">
RISE QUERIES                                                </h6>
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
                            {data === "userHome" && <WelcomeUser />}
                            {data === "addAccount" && <ViewBank />}
                            {data === "billing" && <ViewResponse />}
                            {data === "viewaccount" && <ViewAccount />}
                            {data === "partnerresponse" && <CardResponse />}
                            {data === "riseQueires" && <RaiseQuestion />}
                        </div></div>
                </div>
            </div>
        </div>
    )
}

export default UserSideNav;