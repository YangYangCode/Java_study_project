import React, { useState, useEffect } from "react";
import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";

import Navbar from "./component/Navbar";
import Footer from "./component/Footer";

import ActivitySchedules from "./pages/ActivitySchedule/week_ActivitySchedules";
import AddAS from "./pages/ActivitySchedule/add_ActivitySchedule";
import UpdateAS from "./pages/ActivitySchedule/upDate_ActivitySchedule";

import ClassRoom from "./pages/ClassRoom/ClassRooms";
import AddClassRoom from "./pages/ClassRoom/add_ClassRoom";

import ClassType from "./pages/ClassType/ClassTypes";
import AddClassType from "./pages/ClassType/add_ClassType";


import FitnessInstructors from "./pages/FitnessInstructor/FitnessInstructors";
import AddFitnessInstructor from "./pages/FitnessInstructor/add_FitnessInstructor";

import ManagerActivityList from "./pages/ManagerActivityList";


import Member from "./pages/Member";


import LoginPage from "./pages/Login";
import Home from "./pages/Home";

import Test from "./pages/forTest";






function App() {

  return (
    <>
      <Router future={{ v7_startTransition: true, v7_relativeSplatPath: true }}>
        <Navbar />
        <div className="">
          <Routes>

            <Route
              path="/"
              element={<Home />}
            />

            <Route
              path="/activityschedule"
              element={<ActivitySchedules />}
            />
            <Route
              path="/addactivityschedule"
              element={<AddAS />}
            />
            <Route
              path="/updateactivityschedule"
              element={<UpdateAS />}
            />


            <Route
              path="/classroom"
              element={<ClassRoom />}
            />
            <Route
              path="/addclassroom"
              element={<AddClassRoom />}
            />
            {/* <Route
              path="/updateclassroom"
              element={<UpdateClassRoom />}
            /> */}


            <Route
              path="/classtype"
              element={<ClassType />}
            />
            <Route
              path="/addclasstype"
              element={<AddClassType />}
            />
            {/* <Route
              path="/updateclassRoom"
              element={<UpdateClassRoom />}
            /> */}


            <Route
              path="/manageractivitylist"
              element={<ManagerActivityList />}
            />


            <Route
              path="/fitnessinstructors"
              element={<FitnessInstructors />}
            />
            <Route
              path="/addfitnessinstructor"
              element={<AddFitnessInstructor />}
            />
            {/* <Route
              path="/updateclassRoom"
              element={<UpdateClassRoom />}
            /> */}


            <Route
              path="/member"
              element={<Member />}
            />


            <Route
              path="/login"
              element={<LoginPage />}
            />


            <Route
              path="/fortest"
              element={<Test />}
            />


          </Routes>
        </div>
        {/* <Footer /> */}

      </Router>
    </>
  )
}

export default App
