import React, { useState } from "react";
import MainNav from "../Pages/MainNav";
import WelcomeUser from "../User/WelcomeUser";
import WelcomePartner from "./WelcomePartner";
import PartnerProfile from "./PartnerProfile";
import CardRequests from "./CardRequests";

const PartnerSideNav = () => {
  const [data, setData] = useState("partnerhome");
  return (
    <div>
      <h2>Partner Page</h2>
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
                          onClick={() => setData("profile")}
                        >
                          <img
                            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDtysDKgdhbACvR6DsyK0WJyANgBXIYw4Ukg&usqp=CAU"
                            alt="hugenerd"
                            width="30"
                            height="30"
                            className="rounded-circle"
                          />{" "}
                          <h6 className="ms-1 d-none d-sm-inline  text-dark">
                            PROFILE
                          </h6>{" "}
                        </button>
                      </li>
                      <li>
                        <button
                          onClick={() => setData("cardrequests")}
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
                {data === "userHome" && <WelcomePartner />}
                {data === "profile" && <PartnerProfile />}
                {data === "cardrequests" && <CardRequests />}
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default PartnerSideNav;
