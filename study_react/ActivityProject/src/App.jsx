import React, { useState, useEffect } from "react";
import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";
// import ActivitySchedules from "./pages/ActivitySchedules";
import ActivitySchedules from "./pages/ActivitySchedules_week";
import ClassRoom from "./pages/ClassRooms";
import ClassType from "./pages/ClassTypes";
import Member from "./pages/Member";
import FitnessInstructors from "./pages/FitnessInstructors";
import ManagerActivityList from "./pages/ManagerActivityList";
import Test from "./pages/forTest";



function App() {

  return (
    <>
      <Router future={{ v7_startTransition: true, v7_relativeSplatPath: true }}>

        <div className="">
          <Routes>

            <Route
              path="/activityschedule"
              element={<ActivitySchedules />}
            />

            <Route
              path="/classRoom"
              element={<ClassRoom />}
            />

            <Route
              path="/classType"
              element={<ClassType />}
            />

            <Route
              path="/manageractivitylist"
              element={<ManagerActivityList />}
            />

            <Route
              path="/member"
              element={<Member />}
            />

            <Route
              path="/fitnessInstructors"
              element={<FitnessInstructors />}
            />

            <Route
              path="/fortest"
              element={<Test />}
            />


          </Routes>
        </div>

      </Router>
    </>
  )
}

export default App
