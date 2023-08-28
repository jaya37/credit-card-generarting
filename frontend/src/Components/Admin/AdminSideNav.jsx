import React, { useState } from "react";
import WelcomeAdmin from "./WelcomeAdmin";
import ViewUser from "./ViewUser";
import AddUser from "./AddUser";
import ViewCreditCardPartners from "./ViewCreditCardPartners";
import ViewCardRequests from "./ViewCardRequests";
import ViewQuestions from "./ViewQuestions";

const AdminSideNav = () => {
  const [data, setData] = useState("adminHome");
  return (
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
                        onClick={() => setData("adminHome")}
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
                        onClick={() => setData("viewUsers")}
                      >
                        <img
                          src="data:image/jpeg;base64,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"
                          alt="hugenerd"
                          width="30"
                          height="30"
                          className="rounded-circle"
                        />{" "}
                        <h6 className="ms-1 d-none d-sm-inline  text-dark">
                          MANAGE USERS
                        </h6>{" "}
                      </button>
                    </li>
                    <li>
                      <button
                        onClick={() => setData("card")}
                        data-bs-toggle="collapse"
                        className="nav-link px-0 align-middle "
                      >
                        <img
                          src="https://w7.pngwing.com/pngs/962/794/png-transparent-mastercard-credit-card-mastercard-logo-mastercard-logo-love-text-heart.png"
                          alt="hugenerd"
                          width="30"
                          height="30"
                          className="rounded-circle"
                        />
                        <h6 className="ms-1 d-none d-sm-inline  text-dark">
                        CARD REQUEST
                        </h6>
                      </button>
                    </li>
                    <li>
                      <button
                        onClick={() => setData("partners")}
                        data-bs-toggle="collapse"
                        className="nav-link px-0 align-middle "
                      >
                        <img
                          src="https://cdn-icons-png.flaticon.com/512/6477/6477510.png"
                          alt="hugenerd"
                          width="30"
                          height="30"
                          className="rounded-circle"
                        />
                        <h6 className="ms-1 d-none d-sm-inline  text-dark">
                          VIEW CREDIT CARD PARTNERS
                        </h6>
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
                          width="30"
                          height="30"
                          className="rounded-circle"
                        />
                        <h6 className="ms-1 d-none d-sm-inline  text-dark">
                          GIVE RESPONSE TO CUSTOMER QUERIES
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
              {data === "adminHome" && <WelcomeAdmin />}
              {data === "viewUsers" && <ViewUser />}
              {data === "partners" && <ViewCreditCardPartners />}
              {data === "card" && <ViewCardRequests />}
              {data === "billing" && <ViewQuestions />}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AdminSideNav;
