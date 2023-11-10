const useFetch = () => {
  const fetchData = async (
    endpoint: string,
    method: string | undefined,
    body?: object | undefined,
    token?: string | undefined,
    params?: Record<string, string>
  ) => {
    // this url is to be used in fetch()
    const url = new URL(import.meta.env.VITE_SERVER + endpoint);
    if (params) {
      url.search = new URLSearchParams(params).toString();
    }

    // this header is to be used in fetch()
    const headers: Record<string, string> = {
      "Content-Type": "application/json",
    };
    if (token) {
      headers.Authorization = "Bearer " + token;
    }

    const res: Response = await fetch(url.toString(), {
      method,
      headers,
      body: JSON.stringify(body),
    });

    const data = await res.json();
    let returnValue: { ok: boolean; data: any };

    if (res.ok) {
      if (data.status === "error") {
        returnValue = { ok: false, data: data.response };
      } else {
        returnValue = { ok: true, data };
      }
    } else {
      returnValue = { ok: false, data: data.response };
    }
    return returnValue;
  };
  return fetchData;
};

export default useFetch;
