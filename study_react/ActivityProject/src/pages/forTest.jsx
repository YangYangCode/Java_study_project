import React, { useEffect, useState } from "react";
import { get_all_activitySchedule } from "../service/Service_AS";


function Test() {

    const [test, setTest] = useState('');  // getMember
    const [asList, setAsList] = useState([]); // 保存格式化后的数据

    const handleDelete = async () => {
        try {
            const testInfo = await get_all_activitySchedule(2);
            console.log(testInfo);
            setTest(testInfo);
        } catch (error) {
            console.error("Error during delete:", error);
        }
    };

    

    return (
        <div>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <br/>
            <button onClick={handleDelete}>DO IT</button>
            <button>get AS_data</button>
            <br/>

            <div>
                <p>Response: {test ? JSON.stringify(test) : "No response yet"}</p>
            </div>
        </div>
    );
}

export default Test;