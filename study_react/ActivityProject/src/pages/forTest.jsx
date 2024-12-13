import React, { useEffect, useState } from "react";
import { delete_member_by_id } from "../service/Service_9001_AS";


function Test() {

    const [test, setTest] = useState('');  // getMember

    const handleDelete = async () => {
        try {
            const testInfo = await delete_member_by_id(4);
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