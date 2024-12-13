import React, { useState, useEffect } from "react";
import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";
import ActivitySchedules from "./pages/ActivitySchedules";
import ClassRoom from "./pages/ClassRooms";
import ClassType from "./pages/ClassTypes";



// import "./App.css";

function App() {
  return (
    <Router future={{ v7_startTransition: true, v7_relativeSplatPath: true }}>

      <div className="content">
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

        </Routes>
      </div>

    </Router>
  );
}

export default App;