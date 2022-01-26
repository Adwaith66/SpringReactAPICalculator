import HttpAccess from "../HttpAccess";

const getAPIResponse = (equation) => {
    let apiResponse;
    apiResponse = HttpAccess.get(`/${equation}`).catch(err => {
        if (err.response){
            apiResponse = "Something went wrong with the API";
            console.log('1')
            
        }
        else if(err.request){
            apiResponse = "We are unable to access the API right now";
            console.log(err)
            return apiResponse
        }
        else{
            apiResponse = "Something went wrong";
            console.log('3')

        }
    })
    console.log(apiResponse)

    return apiResponse;
}

export default {getAPIResponse};