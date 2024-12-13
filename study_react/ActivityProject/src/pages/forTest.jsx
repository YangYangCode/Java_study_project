import React, { useEffect, useState } from "react";
import { get_activitySchedule_by_id } from "../service/Service_AS";


function Test() {

    const [test, setTest] = useState('');  // getMember

    const handleDelete = async () => {
        try {
            const testInfo = await get_activitySchedule_by_id(2);
            console.log(testInfo);
            setTest(testInfo);
        } catch (error) {
            console.error("Error during delete:", error);
        }
    };

    return (
        <div>
            <br/>
            <button onClick={handleDelete}>DO IT</button>
            <br/>

            <div>
                <p>Response: {test ? JSON.stringify(test) : "No response yet"}</p>
            </div>
        </div>
    );
}

export default Test;