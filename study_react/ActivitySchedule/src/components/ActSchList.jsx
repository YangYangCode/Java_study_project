import React from 'react';
import { DataGrid } from "@mui/x-data-grid";
import { Box, Paper } from '@mui/material';


const ActSchList = ({Titels, ActSchs}) => {
    const paginationModel = { page: 0, pageSize: 5 };
return (
    <Box        // Table 格式
        sx={{
            display: 'flex',
            alignItems: 'center',
            backgroundColor: '#f5f5f5',
        }}
    >
        <Paper sx={{ height: 400, width: '100%' }} >    
            <DataGrid
                rows={ActSchs}
                columns={Titels}
                initialState={{ pagination: { paginationModel } }}
                pageSizeOptions={[5, 10]}
                // checkboxSelection    // 勾選方框
                sx={{ border: 0}}
            />
        </Paper>
    </Box>
);
};

export default ActSchList;